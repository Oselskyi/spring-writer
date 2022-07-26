package steps;

import com.learning.csv.writer.entiy.Person;
import io.cucumber.java.en.Then;

public class SendPerson {
    Person person;
    @Then("Add new {string}")
    public void addNew(String arg0) {
        person = new Person();
    }
}
