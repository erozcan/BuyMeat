package StepDefinitions;

import Pages.MigrosPages;
import Utils.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class MigrosPagesDefinitions extends BaseClass {

    MigrosPages migros;


    @Before
    public void openHomepage() {
        setDriver();
    }


    @Given("user is on migros homepage")
    public void user_is_on_migros_homepage() {
        migros = new MigrosPages(driver);
        System.out.println("migros homepage is opened");
    }

    @When("user select red meat")
    public void user_select_red_meat() throws InterruptedException {
        migros.selectRedMeat();
        Thread.sleep(1000);

    }

    @Then("red meat page should be open")
    public void red_meat_page_should_be_open() {
        String expected = "En Kaliteli Kırmızı Et Çeşitleri ve Fiyatları - Migros";
        String actual = driver.getTitle();
        Assert.assertEquals(expected, actual);
    }

    @When("user search for meat")
    public void user_search_for_meat() throws InterruptedException {
        migros.searchMeat("dana yemeklik kuşbaşı");
        Thread.sleep(2000);
    }

    @And("click search button")
    public void click_search_button() throws InterruptedException {
        migros.clickSearchButton();
        Thread.sleep(1000);

    }

    @Then("dana yemeklik kusbasi meat should be listed")
    public void dana_yemeklik_kusbasi_meat_should_be_listed() {
        String expected = "dana yemeklik kuşbaşı - Migros";
        String actual = driver.getTitle();
        Assert.assertEquals(expected, actual);
    }

    @When("user select product")
    public void user_select_product() throws InterruptedException {
        migros.selectProduct();
        Thread.sleep(1000);
    }

    @When("user click add basket button")
    public void user_click_add_basket_button() throws InterruptedException {
        migros.clickAddBasketButton();
        Thread.sleep(1000);
    }

    @And("user select bring my adress")
    public void user_select_bring_my_adress() {
        migros.clickBringMyAdress();
    }

    @And("user select city")
    public void user_select_city() throws InterruptedException {
        migros.selectCity();
        Thread.sleep(1000);
    }

    @And("user select district")
    public void user_select_district() throws InterruptedException {
        migros.selectDistrict();
        Thread.sleep(1000);
    }

    @And("user select neighborhood")
    public void user_select_neighborhood() throws InterruptedException {
        migros.selectNeighborhood();
        Thread.sleep(1000);
    }

    @When("user writes note")
    public void user_writes_note() throws InterruptedException {
        migros.writeNote("120 gramlık paketler şeklinde hazırlanmasını istiyorum");
        migros.clickSubmitNoteButton();
        Thread.sleep(1000);
    }

    @And("click add basket buton")
    public void click_add_basket_buton() throws InterruptedException {
        migros.clickAddBasketButton();
        Thread.sleep(1000);
    }

    @When("compare current price with max amount")
    public void compare_current_price_with_max_amount() throws InterruptedException {
        migros.comparePrice();
        Thread.sleep(2000);
    }

    @Then("user should see the product in basket")
    public void user_should_see_the_product_in_basket() {
        migros.closePopUp();

    }

    @After
    public void clsDriver() {
        closeDriver();
    }

}
