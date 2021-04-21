@firdaus
Feature: Automation Test for Astro Assessment

  Scenario Outline: List down all URL available in <Url>
    Given I'm on "<Url>" page
    When I check every link available

    @astro
    Examples:
      | Url |
      | https://www.astro.com.my |

  Scenario Outline: Check for broken Link at <Url>
    #Given I'm on "<Url>" page
    Given "<Url>" page should be up and running

    @astro2
    Examples:
      | Url |
      | https://www.astro.com.my/ |
      |	https://business.astro.com.my/	|
      |	https://corporate.astro.com.my/	|
      |	https://www.astro.com.my/#	|
      |	https://www.astro.com.my/	|
      |	https://promotions.astro.com.my/	|
      |	https://support.astro.com.my/	|
      |	https://promotions.astro.com.my/details/UEFAEURO2020	|
      |	https://promotions.astro.com.my/details/signup-and-win	|
      |	https://product.astro.com.my/ultra	|
      |	https://promotions.astro.com.my/details/UEFAEURO2020	|
      |	https://promotions.astro.com.my/details/signup-and-win	|
      |	https://product.astro.com.my/ultra	|
      |	https://promotions.astro.com.my/details/UEFAEURO2020	|
      |	https://promotions.astro.com.my/details/signup-and-win	|
      |	https://product.astro.com.my/ultra	|
      |	https://shop.astro.com.my/starter-pack	|
      |	https://shop.astro.com.my/value-pack	|
      |	https://shop.astro.com.my/super-pack	|
      |	https://product.astro.com.my/tv	|
      |	https://www.njoi.com.my/home	|
      |	https://content.astro.com.my/	|
      |	https://promotions.astro.com.my/	|
      |	https://www.astro.com.my/contactus	|
      |	https://corporate.astro.com.my/	|
      |	https://www.astrokasih.org/	|
      |	https://www.astro.com.my/mediaroom	|
      |	https://www.astro.com.my/careers/index	|
      |	https://dealers.astro.com.my/aST/faces/global/welcome.faces	|
      |	https://www.goshop.com.my/	|
      |	https://syok.my/	|
      |	https://www.astro.com.my/astro-productions	|
      |	https://www.astro.com.my/en-us/programsales/home.aspx	|
      |	https://complaint.cfm.my/	|
      |	https://api.whatsapp.com/send?phone=60395433838&text=Hi	|
      |	https://www.facebook.com/Astro	|
      |	https://twitter.com/astroonline	|
      |	https://www.astro.com.my/privacy	|
      |	https://www.astro.com.my/terms	|
      |	https://www.astro.com.my/general-terms-and-conditions-for-astro-subscribers	|
      |	https://wa.me/60395433838?text=ENQUIRIES	|
