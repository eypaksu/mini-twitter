import { ClientChallengePage } from './app.po';

describe('client-challenge App', function() {
  let page: ClientChallengePage;

  beforeEach(() => {
    page = new ClientChallengePage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
