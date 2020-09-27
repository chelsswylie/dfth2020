import { StatusToStringPipe } from './status-to-string.pipe';

describe('StatusToStringPipe', () => {
  it('create an instance', () => {
    const pipe = new StatusToStringPipe();
    expect(pipe).toBeTruthy();
  });
});
