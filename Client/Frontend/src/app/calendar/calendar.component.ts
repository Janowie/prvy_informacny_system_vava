import { Component, OnInit } from '@angular/core';
import {formatDate} from '@angular/common';
import {Router} from '@angular/router';
import { Event } from '../_models/event'

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css'],
})

export class CalendarComponent implements OnInit {

  private events: Array<Event>;
  private attandance_possible: Boolean[];
  private today: Date;

  constructor(private router: Router) {

    this.events = [
      {name: 'Hokejbal', date: new Date('05.14.2019'), organisator: 'Petrik', goal: 'Zabavit sa', place: 'Ihrisko', take_with: 'Hokejka', type:'Vyprava', group: 3},
      {name: 'Prespavacka v klubovni', date: new Date('05.09.2019'), organisator: 'Janik', goal: 'Zabavit sa', place: 'Klubovna', take_with: 'Filmy', type:'Prespavacka', group: 2},
      {name: 'Vyprava na Zeleznu studnicku', date: new Date('04.24.2019'), organisator: 'Petrik', goal: 'Zabavit sa', place: 'Zelezna studnicka', take_with: 'Skautska satka', type:'Vyprava', group: 1},
    ]
   }

  ngOnInit() {

    //this.today = this.datePipe.transform(this.today, 'dd.MM.');

    

    // this.events.forEach ( (event) => {
    //   if ( event.date >= 
    // });

  }

  showDetail(i: number) {
    localStorage.setItem('event-detail', JSON.stringify(this.events[i]));
    this.router.navigate(['../event-detail']);
  }

  markAttendance(i: number) {
    localStorage.setItem('event-detail', JSON.stringify(this.events[i]));
    this.router.navigate(['../attendance']);
  }
}
