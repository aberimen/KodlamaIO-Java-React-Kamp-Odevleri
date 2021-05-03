package serviceImpl;

import domain.Campaign;
import service.CampaignService;

public class CampaignManager implements CampaignService {

	@Override
	public void save(Campaign campaign) {
		System.out.println("Kampanya eklendi: " + campaign.getName());

	}

	@Override
	public void update(Campaign campaign) {
		System.out.println("Kampanya güncellendi: " + campaign.getName());

	}

	@Override
	public void delete(Campaign campaign) {
		System.out.println("Kampanya silindi: " + campaign.getName());

	}

}
