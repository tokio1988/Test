package UserCreation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class CreateUser
{
    private WebDriver webDriver;
    private String firstName;
    private String lastName;
    public int count = 0;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://mystore-testlab.coderslab.pl/index.php");
        stopThreed();
    }

    @Test
    public void main() throws Exception
    {
        while(count <= 5)
        {
            clickSignInButton();
            stopThreed();
            clickNoAccountLink();
            stopThreed();
            fillInFirstNameInput();
            stopThreed();
            fillInLastNameInput();
            stopThreed();
            fillInEmailInput();
            stopThreed();
            fillPasswordInput();
            stopThreed();
            clickSaveButton();
            stopThreed();
            clickAccountDetails();
            stopThreed();
            clickAddresses();
            stopThreed();
            fullInCompanyInput();
            stopThreed();
            fillInStreetInput();
            stopThreed();
            fillInPostCodeInput();
            stopThreed();
            fillInCityInput();
            stopThreed();
            fillInCountryInput();
            stopThreed();
            //clickSubmitButton();
            clickSaveButton();
            stopThreed();
            clickSignInButton();
            stopThreed();
            count++;
        }
    }

    @After
    public void tearDown() throws Exception
    {
        stopThreed();
        webDriver.quit();
    }

    public void clickSignInButton()
    {
        WebElement signInButton = webDriver.findElement(By.cssSelector(".user-info a"));
        signInButton.click();
    }

    public void clickNoAccountLink()
    {
        WebElement noAccountButton = webDriver.findElement(By.cssSelector(".no-account a"));
        noAccountButton.click();
    }

    public void fillInFirstNameInput()
    {
        WebElement firstname = webDriver.findElement(By.name("firstname"));
        firstname.clear();
        firstname.sendKeys(setFirstName());
    }


    public void fillInLastNameInput()
    {
        WebElement lastName = webDriver.findElement(By.name("lastname"));
        lastName.clear();
        lastName.sendKeys(setLastName());
    }

    public void fillInEmailInput()
    {
        WebElement email = webDriver.findElement(By.name("email"));
        email.clear();
        email.sendKeys(setEmail() + setDomain());
    }

    public void fillPasswordInput()
    {
        WebElement password = webDriver.findElement(By.name("password"));
        password.clear();
        password.sendKeys(generatePassword(8).toString());
    }

    public void clickSaveButton()
    {
        //WebElement saveButton = webDriver.findElement(By.cssSelector(".btn btn-primary form-control-submit float-xs-right"));
        WebElement saveButton = webDriver.findElement(By.cssSelector(".clearfix button"));
        saveButton.click();
    }

    public void clickAccountDetails()
    {
        WebElement accountDetails = webDriver.findElement(By.cssSelector(".account"));
        accountDetails.click();
    }

    public void clickAddresses()
    {
        WebElement address = webDriver.findElement(By.id("address-link"));
        address.click();
    }

    public void fullInCompanyInput()
    {
        WebElement company = webDriver.findElement(By.name("company"));
        company.clear();
        company.sendKeys(setCompany());
    }

    public void fillInStreetInput()
    {
        WebElement street = webDriver.findElement(By.name("address1"));
        street.clear();
        street.sendKeys(setStreet());
    }

    public void fillInPostCodeInput()
    {
        WebElement postcode = webDriver.findElement(By.name("postcode"));
        postcode.clear();
        postcode.sendKeys(setPostCode());
    }

    public void fillInCityInput()
    {
        WebElement city = webDriver.findElement(By.name("city"));
        city.clear();
        city.sendKeys(setCity());
    }

    public void fillInCountryInput()
    {
        //WebElement country = webDriver.findElement(By.name("id_country"));
        //country.
        Select country = new Select(webDriver.findElement(By.name("id_country")));
        country.selectByVisibleText("United Kingdom");
    }

    public void clickSubmitButton()
    {
        WebElement submitAddress = webDriver.findElement(By.cssSelector(".clearfix button"));
        submitAddress.click();
    }

    public void signOut()
    {
        WebElement signOutButton = webDriver.findElement(By.cssSelector(".logout hidden-sm-down"));
        signOutButton.click();
    }

    public String setFirstName()
    {
        String [] firstNames = {"Lukasz", "Piotr", "Pawel", "Dominika", "Grzegorz", "Lucja", "Naruto", "Goku", "Vegeta"};
        firstName = firstNames[randomIndex()];
        return firstName;

    }

    public String setLastName()
    {
        String [] lastNames = {"Kowalski", "Nowak", "Szewczyk", "Slowacki", "Mickiewicz", "Kaczynski", "Ziobro", "Sikorski", "Tusk"};
        lastName = lastNames[randomIndex()];
        return lastName;
    }

    public String setEmail()
    {
        String email = firstName + "." + lastName;
        return email;
    }

    public String setDomain()
    {
        String [] domains = {"@gmail.com", "@yahoo.com", "@wp.pl", "@onet.pl", "@hotmail.com", "@gazeta.pl", "@Outlook.com", "@apple.com", "@interia.pl"};
        return domains[randomIndex()];
    }

    public String setCompany()
    {
        String [] companies = {"Apple", "Polsat", "TVN", "Smartware", "Microsoft", "Nokia", "Samsung", "Sony", "Castorama"};
        return companies[randomIndex()];
    }

    public String setStreet()
    {
        String [] streets = {"Wyzwolenia", "Legnicka", "Wojska Polskiego", "Różana", "Szpitalna", "Rynek", "Cinciały", "Drabika", "Hiacyntowa"};
        return  streets[randomIndex()];
    }

    public String setPostCode()
    {
        String [] postCodes = {"44-120","50-573","60-573","70-573","80-573","90-573","46-573","48-573","43-573"};
        return postCodes[randomIndex()];
    }

    public String setCity()
    {
        String [] cities = {"Wroclaw", "Pyskowice", "Kraków", "Warszawa", "Konin", "Paryż", "Londyn", "Tokio", "Nowy York"};
        return cities[randomIndex()];
    }

    public int randomIndex()
    {
        Random random = new Random();
        int randomIndexNumber = random.nextInt(9);
        return  randomIndexNumber;
    }

    private static char[] generatePassword(int length)
    {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[length];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        for(int i = 4; i< length ; i++)
        {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return password;
    }

    public void stopThreed()
    {
        Thread t1 = new Thread()
        {
            {
                System.out.println("Thread 1");
                try {
                    Thread.currentThread();
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
