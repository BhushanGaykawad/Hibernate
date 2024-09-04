package com.example.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.example.formbeans.HelloActionForm;

public class HelloAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HelloActionForm haf=(HelloActionForm)form;
		String uname=haf.getUname();
		request.setAttribute("uname", uname);
		
		return mapping.findForward("wish");
	}
}
