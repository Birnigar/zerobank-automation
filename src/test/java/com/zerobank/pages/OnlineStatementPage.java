package com.zerobank.pages;

import com.zerobank.utulities.BrowserUtils;
import com.zerobank.utulities.Driver;
import org.openqa.selenium.By;

import java.io.File;

public class OnlineStatementPage extends AbstractPageBase{
    private String fileName;

    /**
     * This method navigates to Statement year
     *
     * @param linkText
     */
    public void navigateToStatement(String linkText) {
       BrowserUtils.wait(12);
       Driver.getDriver().findElement(By.linkText(linkText)).click();
    }

    /**
     * This method finds statements amount searched year and verified with count
     *
     * @param year  statement year
     * @param count amount of statement from example table
     * @return true if count and displayed statement amount same
     * false if count and displayed statement amount not same
     */
    public boolean isDisplayed(String year, String count) {
        return Driver.getDriver().findElements(By.xpath("//div[@id='os_" + year + "']//a")).size() == Integer.parseInt(count);
    }

    /**
     * This methods verifies download process.
     * @param fileName searched file
     * @return true if file exist in local directory
     *          false if file doesn't exist in local directory
     */
    public boolean isDownloaded(String fileName) {
        this.fileName=fileName;
        String file=findFile(this.fileName);
        return file != null;
    }

    /**
     * This method verifies downloaded file type
     * @param format searched format
     * @return true if file name contains searched format type
     *          false if file name doesn't contain searched format type
     */
    public boolean isDownloadedType(String format){
        String file=findFile(fileName);
        return file.contains(format);
    }

    /**
     * Search local download directory and return searched file full name if exist
     * @param fileName searched file name. Full or partial.
     * @return full file name as string. (including file type)
     *         if file doesn't exist return null
     */
    public String findFile(String fileName){
        try {
            File folder = new File("\\Users\\Admin\\Downloads\\");
            File[] files=folder.listFiles();
            assert files != null;
            for (File file : files) {
                if(file.getName().contains(fileName)){
                    return file.getName();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
