package net.devstudy.tag.jsp1;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class AttrTag extends TagSupport {
	private static final long serialVersionUID = 4036918707698747759L;
	private boolean condition;

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			if (condition) {
				out.println("Condition is true");
			} else {
				out.println("Condition is false");
			}
			condition = false;
			return SKIP_BODY;
		} catch (IOException e) {
			throw new JspException(e);
		}
	}

	public void setCondition(boolean condition) {
		this.condition = condition;
	}
}
