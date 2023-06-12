package com.swulab.eatswunee.domain.chatroom.application.port.in.command;

import com.swulab.eatswunee.domain.chatroom.application.port.out.command.FindChatMessageCommand;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetChatMessagesCommand {

  private RecruitStatus recruitStatus;
  private String recruitTitle;
  private String recruitSpot;
  private LocalTime recruitStartTime;
  private LocalTime recruitEndTime;
  private LocalDateTime recruitCreatedAt;
  private String senderName;

  List<ChatMessageCommand> commandList;


  public GetChatMessagesCommand(Recruit recruit, List<FindChatMessageCommand> commands, String userName) {
    this.recruitStatus = recruit.getStatus();
    this.recruitTitle = recruit.getTitle();
    this.recruitSpot = recruit.getRestaurant();
    this.recruitStartTime = recruit.getStartTime();
    this.recruitEndTime = recruit.getStartTime();
    this.recruitCreatedAt = recruit.getCreatedAt();
    this.commandList = commands.stream().map(ChatMessageCommand::new).toList();

    List<FindChatMessageCommand> senderCommands = commands.stream()
        .filter(command -> !(command.getMessageSender().equals(userName))).toList();
    this.senderName = commands.size()==0 ? "notFound" : senderCommands.get(0).getMessageSender();

  }


  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class ChatMessageCommand {

    private String messageSender;
    private String messageContent;
    private LocalDateTime messageCreatedAt;
    private Boolean messageIsRead;


    public ChatMessageCommand(FindChatMessageCommand command) {
      this.messageSender = command.getMessageSender();
      this.messageContent = command.getMessageContent();
      this.messageCreatedAt = command.getMessageCreatedAt();
      this.messageIsRead = command.getMessageIsRead();
    }
  }


}
