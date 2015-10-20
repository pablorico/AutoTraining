package autotraining.basicajax.services;

import org.springframework.stereotype.Service;

@Service
public class ShotServiceImpl implements ShotService {
	
	private int shot;
	
	public ShotServiceImpl() {
		shot=0;		
	}

	@Override
	public int shot() {
		return ++shot;
	}

}
