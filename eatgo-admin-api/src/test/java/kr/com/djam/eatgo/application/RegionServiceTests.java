package kr.com.djam.eatgo.application;

import kr.com.djam.eatgo.domain.Region;
import kr.com.djam.eatgo.domain.RegionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

class RegionServiceTests {

    private RegionService regionService;

    @Mock
    private RegionRepository regionRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        regionService = new RegionService(regionRepository);
    }

    @Test
    public void addRegion(){
        Region mockRegion = Region.builder()
                .name("Seoul")
                .build();
        given(regionRepository.save(any())).willReturn(mockRegion);

        Region region = regionService.addRegion("Seoul");

        assertThat(region.getName(),is("Seoul"));
    }
    @Test
    public void getRegions(){
        List<Region> mockRegions = new ArrayList<>();
        mockRegions.add(Region.builder().name("서울").build());

        given(regionRepository.findAll()).willReturn(mockRegions);
        List<Region> regions = regionService.getRegions();

        Region region = regions.get(0);
        assertThat(region.getName(), is("서울"));
    }


}