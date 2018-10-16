package com.gmail.safordog.model;

public class TemplateResponse {

    private String addDish = "<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"/styles/styles.css\"/>" +
            "</head><body><fieldset><div id=\"logo\"><u>MENU INTERFACE</u><p>add new dish</p></div>" +
            "<div id=\"content\"><form action=\"/new_dish\" method=\"post\"><input type=\"text\" name=\"name\"" +
            "placeholder=\"input name\"/><input type=\"number\" name=\"price\" placeholder=\"input price\"/>" +
            "<input type=\"number\" name=\"weight\" placeholder=\"input weight\"/>" +
            "<input type=\"text\" name=\"discount\" placeholder=\"input discount\"/>" +
            "<br><br><input type=\"submit\" value=\"add this dish\"></form></div></fieldset></body></html>";

    public TemplateResponse() {
    }

    public String getAddDish() {
        return addDish;
    }

    public void setAddDish(String addDish) {
        this.addDish = addDish;
    }
}
