package src.linus.jaxb;

import java.io.File;
import java.util.Iterator;

import generated.AssetDetails;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class AssetDetails_XMLtoObject {
	public static void main(String ...a){
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(AssetDetails.class);
			Unmarshaller jaxbUnmarshaller= jaxbContext.createUnmarshaller();
			
			AssetDetails assetDetails = (AssetDetails) jaxbUnmarshaller.unmarshal(new File("D:\\PracticePrograms\\JAXB_practice\\assetDetails.xml"));
			
			System.out.println(assetDetails);
			System.out.println(assetDetails.getAssetId());
			System.out.println(assetDetails.getOwner());
			System.out.println(assetDetails.getOwnerDetails().getName());
			System.out.println(assetDetails.getOwnerDetails().getAge());
			System.out.println(assetDetails.getOwnerDetails().getSex());
			System.out.println(assetDetails.getOwnerDetails().getCompany());
			System.out.println(assetDetails.getOwnerDetails().getAddress().getHouseNumber());
			System.out.println(assetDetails.getOwnerDetails().getAddress().getBuilding());
			System.out.println(assetDetails.getOwnerDetails().getAddress().getSociety());
			System.out.println(assetDetails.getOwnerDetails().getAddress().getStreet());
			System.out.println(assetDetails.getOwnerDetails().getAddress().getArea());
			System.out.println(assetDetails.getOwnerDetails().getAddress().getCity());
			System.out.println(assetDetails.getOwnerDetails().getAddress().getDistrict());
			System.out.println(assetDetails.getOwnerDetails().getAddress().getPinCode());
			System.out.println(assetDetails.getOwnerDetails().getAddress().getState());
			System.out.println(assetDetails.getOwnerDetails().getAddress().getCountry());
			System.out.println(assetDetails.getBankAccounts().getBank().size());
			
			for(AssetDetails.BankAccounts.Bank bank : assetDetails.getBankAccounts().getBank()){
				System.out.println(bank.getBankName());
				System.out.println(bank.getCustomerId());
				
				for(AssetDetails.BankAccounts.Bank.Account account: bank.getAccount()){
					System.out.println(account.getAccountNo());
					System.out.println(account.getAccountType());
					System.out.println(account.getIfscCode());
					
					for(AssetDetails.BankAccounts.Bank.Account.Card card : account.getCard()){
						System.out.println(card.getCardType());
						System.out.println(card.getVendor());
						System.out.println(card.getDigits());
					}
					
					for(AssetDetails.BankAccounts.Bank.Account.FixedDeposit fd : account.getFixedDeposit()){
						System.out.println(fd.getDepositNumber());
						System.out.println(fd.getMaturityDate());
						System.out.println(fd.getPrincipal());
						System.out.println(fd.getRoi());
						System.out.println(fd.getMaturityValue());
					}
				}
			}
			
			if(assetDetails.getOthers().getAsset() != null){
				System.out.println(assetDetails.getOthers().getAsset().getAssetType());
				System.out.println(assetDetails.getOthers().getAsset().getAgency());
				System.out.println(assetDetails.getOthers().getAsset().getReferenceDetail());
			}
		}
		catch(JAXBException je){
			System.out.println("JAXBException occurred "+je);
		}
		catch(Exception e){
			System.out.println("Exception raised "+e);
		}
		
	}    //main()
}    //AssetDetails_XMLtoObject
