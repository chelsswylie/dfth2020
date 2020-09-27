import {Pipe, PipeTransform} from '@angular/core';
import {ProductionStepStatus} from '../../generated_src';

@Pipe({
  name: 'statusToString'
})
export class StatusToStringPipe implements PipeTransform {

  transform(value: ProductionStepStatus, ...args: unknown[]): unknown {
    return {
      [ProductionStepStatus.NotStarted]: 'Not Started',
      [ProductionStepStatus.InProgress]: 'In Progress' as ProductionStepStatus,
      [ProductionStepStatus.Complete]: 'Complete' as ProductionStepStatus
    }[value];
  }
}
