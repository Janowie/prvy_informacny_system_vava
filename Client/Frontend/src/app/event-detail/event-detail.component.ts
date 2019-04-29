import { Component, OnInit } from '@angular/core';
import { Event } from '../_models/event';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-event-detail',
  templateUrl: './event-detail.component.html',
  styleUrls: ['./event-detail.component.css']
})
export class EventDetailComponent implements OnInit {

  event: Event;
  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.event = JSON.parse(localStorage.getItem('event-detail'));
  }

  ngOnDestroy() {
    localStorage.removeItem('event-detail');
  }

}
