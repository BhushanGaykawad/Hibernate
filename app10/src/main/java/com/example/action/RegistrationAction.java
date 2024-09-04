package com.example.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.example.formbeans.RegistrationActionForm;
import com.example.service.StudentService;

public class RegistrationAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		RegistrationActionForm raf=(RegistrationActionForm) form;
		String sid=raf.getSid();
		String sname=raf.getSname();
		String saddr=raf.getSaddr();
		StudentService service= new StudentService();
		String status=service.Register(sid, sname, saddr);
		
		return mapping.findForward(status);
		}
}
