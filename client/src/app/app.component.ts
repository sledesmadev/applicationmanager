import { Component, OnInit } from '@angular/core';
import { ApplicationService } from './services/application-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  constructor(private applicationService: ApplicationService) { }

  ngOnInit(): void {
  }

}
