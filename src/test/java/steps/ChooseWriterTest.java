package steps;

import com.learning.csv.writer.entiy.AllowToWrite;
import com.learning.csv.writer.entiy.Interaction;
import com.learning.csv.writer.entiy.Person;
import com.learning.csv.writer.service.CSVWriter;
import com.learning.csv.writer.service.Writer;
import com.learning.csv.writer.service.WriterFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ChooseWriterTest {

    WriterFactory factory = null;
    Writer actualWriter;
    AllowToWrite object;


    @Given("Return right writer")
    public void return_right_writer() {
        factory = new WriterFactory();
    }

    @When("I'll send an object of Person type")
    public void i_ll_send_an_object_of_person_type() {
        object = new Person();
        actualWriter = factory.getWriter(object);
    }

    @When("I'll send an object of interaction type")
    public void i_ll_send_an_object_of_interaction_type() {
        object = new Interaction();
        actualWriter = factory.getWriter(object);
    }

    @Then("factory return a writer with path - person.csv")
    public void factory_return_a_writer_with_path_person_csv() {
        Assert.assertEquals(new CSVWriter("Person.csv"), actualWriter);
    }

    @Then("factory return a writer with path - interaction.csv")
    public void factory_return_a_writer_with_path_interaction_csv() {
        Assert.assertEquals(new CSVWriter("Interaction.csv"), actualWriter);
    }


//    @Given("Return right writer")
//    public void return_right_writer() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("I'll send an object of interaction type")
//    public void i_ll_send_an_object_of_interaction_type() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("factory return a writer with path - interaction.csv")
//    public void factory_return_a_writer_with_path_interaction_csv() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }


}
