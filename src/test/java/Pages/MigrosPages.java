package Pages;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


public class MigrosPages {

    WebDriver driver;

    public MigrosPages(WebDriver driver) {
        this.driver = driver;
    }

    By btn_meatchickenfish = By.xpath("//*[@id=\"header-menu\"]/div/nav/div[2]/ul/li[2]/a/span");
    By btn_redmeat = By.xpath("//*[@id=\"header-menu\"]/div/nav/div[2]/ul/li[2]/ul/div/div/div/ul/li[1]/a");
    By txt_search = By.id("search");
    By btn_search = By.xpath("//*[@id=\"main-search\"]/button");
    By select_product = By.xpath("//*[@id=\"page-area\"]/div/div/div[3]/div[3]/div[1]/div/form/div[1]/h5/a");
    By txt_productdetailnote = By.id("product-detail-note-textarea");
    By btn_submit = By.xpath("//*[@id=\"product-detail-add-note-button\"]/span[1]");
    By btn_addbasket = By.xpath("//*[@id=\"product-page\"]/div/div/div[1]/div[2]/div/div[2]/form/div/div[2]/button");
    By btn_bringmyadress = By.xpath("//*[@id=\"delivery-options-modal_home\"]/mat-card/mat-card-content/img");
    By btn_gobasket = By.xpath("//*[@id=\"cart-bar\"]/div/div[1]/div/div[2]/a");
    By btn_closepopup = By.xpath("//*[@id=\"cartCampaignModal\"]/div/div/div[1]/button");


    public void selectRedMeat() {
        WebElement element = driver.findElement(btn_meatchickenfish);
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
        act.click();
        driver.findElement(btn_redmeat).click();
    }

    public void searchMeat(String meat) {
        driver.findElement(txt_search).sendKeys(meat);
    }

    public void clickSearchButton() {
        driver.findElement(btn_search).click();
    }

    public void selectProduct() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0 , 250)");
        driver.findElement(select_product).sendKeys(Keys.ENTER);
    }

    public void writeNote(String specialnote) {
        driver.findElement(txt_productdetailnote).sendKeys(specialnote);
    }

    public void clickSubmitNoteButton() {
        driver.findElement(btn_submit).click();
    }

    public void clickAddBasketButton() {
        driver.findElement(btn_addbasket).click();
    }

    public void clickBringMyAdress() {
        WebElement adress = driver.findElement(By.xpath("//*[@id=\"modal-component\"]/div/div"));
        adress.findElement(btn_bringmyadress).click();

    }

    public void selectCity() {
        driver.findElement(By.xpath("//*[@id=\"mat-select-0\"]")).click();
        driver.findElement(By.id("mat-option-0")).click();

    }

    public void selectDistrict() {
        driver.findElement(By.xpath("//*[@id=\"mat-select-value-3\"]")).click();
        driver.findElement(By.id("mat-option-83")).click();

    }

    public void selectNeighborhood() {
        driver.findElement(By.id("delivery-address-dropdown_district")).click();
        driver.findElement(By.id("mat-option-120")).click();

    }

    public void comparePrice() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"headerCartContainer\"]/div[1]/div[1]/button/span")).click();
        String maxamount = driver.findElement(By.xpath("//*[@id=\"cart-bar\"]/div/div[1]/div/div[3]/div[1]")).getText();
        Double newmaxamount = Double.valueOf(maxamount.replaceAll("[^\\d.]", ""));
        String currentprice = driver.findElement(By.xpath("//*[@id=\"cart-bar\"]/div/div[2]/ul/li/form/table/tbody/tr[1]/td[4]/div")).getText();
        Double newcurrentprice = Double.valueOf(currentprice.replaceAll("[^\\d.]", ""));
        if (newmaxamount > newcurrentprice) {
            driver.findElement(By.xpath("//*[@id=\"cart-bar\"]/div/div[2]/ul/li/form/table/tbody/tr[1]/td[3]/div/div/button[2]/i")).click();
            Thread.sleep(1000);
            String lastmaxamount = driver.findElement(By.xpath("//*[@id=\"cart-bar\"]/div/div[2]/ul/li/form/table/tbody/tr[1]/td[4]/div")).getText();
            Double lasttotalprice = Double.valueOf(lastmaxamount.replaceAll("[^\\d.]", ""));
            driver.findElement(btn_gobasket).click();
            Thread.sleep(1000);
            String summaryrevenue = driver.findElement(By.xpath("//*[@id=\"summaryRevenue\"]")).getText();
            Double newsummaryamount = Double.valueOf(summaryrevenue.replaceAll("[^\\d.]", ""));
            if (lasttotalprice == newsummaryamount) {
                System.out.println("product price and basket price is equal");
            }
        }
    }


    public void closePopUp() {
        driver.findElement(btn_closepopup).click();
    }


}
