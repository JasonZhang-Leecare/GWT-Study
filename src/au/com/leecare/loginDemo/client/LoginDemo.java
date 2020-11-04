package au.com.leecare.loginDemo.client;

import au.com.leecare.loginDemo.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point for Login Function, will validate user name and password
 *
 * @auther Jason Zhang
 */

public class LoginDemo implements EntryPoint {

  @Override
  public void onModuleLoad() {
    final Button sendButton = new Button("Go");
    final TextBox nameField = new TextBox();
    final Label errorLabel = new Label();

    final PasswordTextBox passwordField = new PasswordTextBox();

    sendButton.addStyleName("loginButton");

    RootPanel.get("nameFieldContainer").add(nameField);
    RootPanel.get("passwordFieldContainer").add(passwordField);
    RootPanel.get("sendButtonContainer").add(sendButton);
    RootPanel.get("errorLabelContainer").add(errorLabel);

    nameField.setFocus(true);
    nameField.selectAll();

    ClickHandler handler =
        new ClickHandler() {
          @Override
          public void onClick(ClickEvent event) {
            errorLabel.setText("");
            String name = nameField.getText();

            if (!FieldVerifier.isValidName(name)) {
              errorLabel.setText("User Name not valid");
              return;
            }

            String password = passwordField.getText();

            if (!FieldVerifier.isValidPassword(password)) {
              errorLabel.setText("Password not valid");
              return;
            }
          }
        };

    sendButton.addClickHandler(handler);
  }
}
