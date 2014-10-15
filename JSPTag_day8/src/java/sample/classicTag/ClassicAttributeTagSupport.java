/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.classicTag;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author thienlh
 */
public class ClassicAttributeTagSupport extends TagSupport {
    private String count;
    private int nCount;

    public void setCount(String count) {
        this.count = count;
        System.out.println("setCount"+count);
        try {
            nCount = Integer.parseInt(count);
        } catch (NumberFormatException numberFormatException) {
            nCount = 9394;
        }
    }

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        for (int i = 0; i < nCount; i++) {
            try {
                out.println(i + ",");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return EVAL_PAGE;
    }
    
}
