package Elements;

import Pages.Page;

public abstract class Element {
    protected Page container;
    public Element(Page page)
    {
        this.container = page;
    }
}