package com.java.rehber.bean;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("name.validate.rehber")
public class ValidateName implements Validator {

    @Override
    public void validate(final FacesContext context,
                         final UIComponent arg1,
                         final Object arg2) throws ValidatorException {
        if (arg1 instanceof UIInput) {
            UIInput uiInput = (UIInput) arg1;
            String valueStr = (String) uiInput.getSubmittedValue();
            if ((valueStr.length() <= 2) || (valueStr.length() > 20)) {
                FacesMessage facesMessage = new FacesMessage("length of entered string should be between 2 to 20");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                //                context.addMessage("surnameId", facesMessage);
                throw new ValidatorException(facesMessage);
            }

        }
    }

}
