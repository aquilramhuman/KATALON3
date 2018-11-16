import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.phptravels.net/admin')

WebUI.setText(findTestObject('AddSuppliers/Page_Administator Login/input_email'), 'admin@phptravels.com')

WebUI.setText(findTestObject('AddSuppliers/Page_Administator Login/input_password'), 'demoadmin')

WebUI.click(findTestObject('AddSuppliers/Page_Administator Login/button_Login'))

WebUI.click(findTestObject('AddSuppliers/Page_Dashboard/a_Accounts'))

WebUI.click(findTestObject('AddSuppliers/Page_Dashboard/a_Suppliers'))

WebUI.click(findTestObject('AddSuppliers/Page_Suppliers Management/button_Add'))

def ExcelData = findTestData('SupplierDB/AddSupplierData')

int i = 1

WebUI.setText(findTestObject('glovariable/fieldData', [('dynamicvariable') : 'fname']), ExcelData.getValue(i++, 1))

WebUI.setText(findTestObject('glovariable/fielddata', [('dynamicvariable') : 'lname']), ExcelData.getValue(i++, 1))

WebUI.setText(findTestObject('glovariable/fielddata', [('dynamicvariable') : 'email']), ExcelData.getValue(i++, 1))

WebUI.setText(findTestObject('glovariable/fielddata', [('dynamicvariable') : 'password']), ExcelData.getValue(i++, 1))

WebUI.setText(findTestObject('glovariable/fielddata', [('dynamicvariable') : 'mobile']), ExcelData.getValue(i++, 1))

WebUI.click(findTestObject('CreateAdmin/SelectDropDown'))

WebUI.delay(1)

WebUI.click(findTestObject('CreateAdmin/Country', [('Country') : ExcelData.getValue(i++, 1)]))

WebUI.delay(5)

WebUI.setText(findTestObject('glovariable/fielddata', [('dynamicvariable') : 'address1']), ExcelData.getValue(i++, 1))

WebUI.setText(findTestObject('glovariable/fielddata', [('dynamicvariable') : 'address2']), ExcelData.getValue(i++, 1))

WebUI.click(findTestObject('AddSuppliers/ClickSupplier'))

WebUI.click(findTestObject('AddSuppliers/SelectApplier', [('supplier') : ExcelData.getValue(i++, 1)]))

WebUI.setText(findTestObject('glovariable/fielddata', [('dynamicvariable') : 'itemname']), ExcelData.getValue(i++, 1))

WebUI.click(findTestObject('AddSuppliers/ClickAssignHotel'))

WebUI.click(findTestObject('AddSuppliers/SelectAssignHotel', [('assignhotel') : ExcelData.getValue(i++, 1)]))

WebUI.click(findTestObject('AddSuppliers/ClickAssignTours'))

WebUI.click(findTestObject('AddSuppliers/SelectAssignTours', [('assigntours') : ExcelData.getValue(i++, 1)]))

WebUI.click(findTestObject('AddSuppliers/ClickSelectCars'))

WebUI.click(findTestObject('AddSuppliers/SelectSelectCars', [('assigncars') : ExcelData.getValue(i++, 1)]))

def dbdataForPermission = findTestData('dbCheckbox1/permission')

for (def index : (1..dbdataForPermission.getRowNumbers())) {
    for (def indexc : (1..dbdataForPermission.getColumnNumbers())) {
        WebUI.scrollToElement(findTestObject('CreateAdmin/checkbox', [('value') : dbdataForPermission.getValue(indexc, index)]), 
            10)

        WebUI.click(findTestObject('CreateAdmin/checkbox', [('value') : dbdataForPermission.getValue(indexc, index)]))
    }
}

WebUI.click(findTestObject('AddSuppliers/SupplierSubmit'))

WebUI.verifyElementPresent(findTestObject('AddSuppliers/VerifySupplierPresent'), 5)

WebUI.closeBrowser()

