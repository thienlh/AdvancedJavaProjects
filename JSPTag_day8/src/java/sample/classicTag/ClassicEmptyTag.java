/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.classicTag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 *
 * @author thienlh
 */
public class ClassicEmptyTag implements Tag {

    private PageContext pageContext;
    private Tag parent;

    public void setPageContext(PageContext pc) {
        this.pageContext = pc;
    }

    public void setParent(Tag t) {
        this.parent = t;
    }

    public Tag getParent() {
        System.out.println("");
        return this.parent;
    }

    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print("This is empty classic tag");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return SKIP_BODY;
    }

    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print("This is empty classic tag</br>-End Tag");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EVAL_PAGE;
    }

    public void release() {
    }

}
