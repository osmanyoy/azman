package com.java.rehber.bean;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("com.rehber.password")
public class ValidatePassword implements Validator {

    @Override
    public void validate(final FacesContext context,
                         final UIComponent arg1,
                         final Object arg2) throws ValidatorException {
        String password1 = (String) arg2;
        UIInput inputPasswd = (UIInput) arg1.findComponent("repasswordId");
        String password2 = (String) inputPasswd.getSubmittedValue();
        if ((password1 == null) || !password1.equals(password2)) {
            FacesMessage facesMessage = new FacesMessage("please re enter your password");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage("repasswordId", facesMessage);
            throw new ValidatorException(facesMessage);

        }
    }


}
