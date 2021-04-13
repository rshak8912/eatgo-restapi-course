package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;


public class RegionServiceTests {
    @InjectMocks
    private RegionService regionService;
    @Mock
    private RegionRepository regionRepository;

    @Before
    public void setUp() {
        initMocks(this);
        regionService = new RegionService(regionRepository);
    }

    @Test
    public void getRegions() throws Exception {
         List<Region> mockRegions = new ArrayList<>();

        mockRegions.add(Region.builder().name("Seoul").build());

        given(regionRepository.findAll()).willReturn(mockRegions);

        List<Region> regions = regionService.getRegions();
        Region region = regions.get(0);
        assertThat(region.getName(), is("Seoul"));
    }
    @Test
    public void addRegion() throws Exception {
        Region region = regionService.addRegion("Seoul");

        verify(regionRepository).save(any());

        assertThat(region.getName(), is("Seoul"));
    }
}