import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms'

@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  styleUrls: ['./add-event.component.css']
})

export class AddEventComponent implements OnInit {

  eventForm: FormGroup;
  submitted = false;
  success = false;


  constructor(private formBuilder: FormBuilder) { 
    this.eventForm = this.formBuilder.group({
      name: ['', Validators.required],
      organisator: ['', Validators.required],
      place: [''],
      date: [''],
      type: [''],
      goal: ['', Validators.required],
      take_with: ['']
    })
  }

  onSubmit() {
    this.submitted = true;
    if (this.eventForm.invalid) return;   
    this.success = true;

    window.alert("Akcia " + this.eventForm.controls.name.value + " pridana.")
  }

  ngOnInit() {
    
  }

}
