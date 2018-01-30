import { Component, OnInit } from '@angular/core';
import { MessageService } from '../shared/message/message.service';

@Component({
  selector: 'app-message-list',
  templateUrl: './message-list.component.html',
  styleUrls: ['./message-list.component.css']
})
export class MessageListComponent implements OnInit {
  messages: Array<any>;

  constructor(private messageService: MessageService) { }

  ngOnInit() {
    this.messageService.getAll().subscribe(data => {
      this.messages = data;
    });
  }

}
