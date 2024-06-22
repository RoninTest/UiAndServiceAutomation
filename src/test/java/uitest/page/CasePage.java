package uitest.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import service.driver.Driver;

public class CasePage extends Driver {

    public CasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "searchBoxOld-M1esqHPyWSuRUjMCALPK")
    public WebElement searchFieldClickElement;

    @FindBy(xpath = "//input[@placeholder='Ürün, kategori veya marka ara']")
    public WebElement searchField;

    @FindBy(className = "searchBoxOld-yDJzsIfi_S5gVgoapx6f")
    public WebElement searchButton;
    @FindBy(xpath = "//a[contains(text(), \"Reddet\")]")
    public WebElement cookieReject;

    @FindBy(id = "productReviews")
    public WebElement comments;

    @FindBy(css = ".hermes-ImageGallery-module-CPu3qfJsb2o24r3rgmmL")
    public WebElement productPicture;

    @FindBy(css = ".hermes-Sort-module-AI2HFuJVJiCMkxgX4Rac")
    public WebElement sortingComment;

    @FindBy(className = "hermes-Sort-module-Zwr_VRf_e4tZXl5J1PgT")
    public WebElement sortingCommentOption;

    @FindBy(xpath = "//div[contains(text(), \"En yeni değerlendirme\")]")
    public WebElement theLatestComment;

    @FindBy(className = "hermes-FiltersContainer-module-y2OKYBpvrZAunHs0vsBg")
    public WebElement productComments;

    @FindBy(xpath = "//div[@class='hermes-ReviewCard-module-PbSfiSWIgfswGGBaOrw7'][1]")
    public WebElement likingComment;

    @FindBy(xpath = "//span[contains(text(), \"Teşekkür Ederiz.\")]")
    public WebElement thankYourLiking;

    @FindBy(xpath = "//div[contains(text(), \"Beğen\")]")
    public WebElement likingProduct;

    @FindBy(id = "btnLogin")
    public WebElement loginButton;

    @FindBy(id = "offering-price")
    public WebElement productDetailPrice;

    @FindBy(id = "addToCart")
    public WebElement addToCartButton;

    @FindBy(css = ".checkoutui-ProductOnBasketHeader-zdTSacusLu4Cu0LDpmnB > button:nth-of-type(1)")
    public WebElement goToBasketButton;

    @FindBy(id = "basket_payedPrice")
    public WebElement basketPrice;
}
