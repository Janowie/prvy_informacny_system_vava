import { Component, OnInit } from '@angular/core';
import { Event } from '../_models/event';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-attendance',
  templateUrl: './attendance.component.html',
  styleUrls: ['./attendance.component.css']
})
export class AttendanceComponent implements OnInit {

  event: Event;
  scann: Boolean = false;

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.event = JSON.parse(localStorage.getItem('event-detail'));
  }

  openCamera() {
    this.scann = true;
  }

  ngOnDestroy() {
    localStorage.removeItem('event-detail');
  }

}
