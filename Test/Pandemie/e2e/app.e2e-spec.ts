import { PandemiePage } from './app.po';

describe('pandemie App', function() {
  let page: PandemiePage;

  beforeEach(() => {
    page = new PandemiePage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
