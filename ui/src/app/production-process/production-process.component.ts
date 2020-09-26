import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-production-process',
  templateUrl: './production-process.component.html',
  styleUrls: ['./production-process.component.css'],
})
export class ProductionProcessComponent implements OnInit {
  //title = 'dfth2020-ui';

  currentProductionStepsAndStatus = [
    { title: 'Marker Making and Cutting', stepCode: 'firstStep', status: 'Pending' },
    { title: 'Production Preparation', stepCode: 'secondStep', status: 'Pending' },
    { title: 'Front Panel', stepCode: 'thirdStep', status: 'Pending' },
    { title: 'Back Panel', stepCode: 'fourthStep', status: 'Pending' },
    { title: 'Marriage', stepCode: 'fifthStep', status: 'Pending' },
    { title: 'Waistband', stepCode: 'sixthStep', status: 'Pending' },
    { title: 'Finishing', stepCode: 'seventhStep', status: 'Pending' },
    { title: 'Quality Control', stepCode: 'eighthStep', status: 'Pending' },
    { title: 'Fulfillment', stepCode: 'ninthStep', status: 'Pending' },
  ];
  isLinear = false;

  constructor() {}

  ngOnInit(): void {}
}
