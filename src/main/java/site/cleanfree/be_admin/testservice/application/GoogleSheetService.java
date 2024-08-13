package site.cleanfree.be_admin.testservice.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.cleanfree.be_admin.testservice.domain.CarryCabin;
import site.cleanfree.be_admin.testservice.domain.CarryCabinAccess;
import site.cleanfree.be_admin.testservice.domain.CookingStation;
import site.cleanfree.be_admin.testservice.domain.CookingStationAccess;
import site.cleanfree.be_admin.testservice.domain.CozyHouse;
import site.cleanfree.be_admin.testservice.domain.CozyHouseAccess;
import site.cleanfree.be_admin.testservice.domain.Cozyquick;
import site.cleanfree.be_admin.testservice.domain.CozyquickAccess;
import site.cleanfree.be_admin.testservice.domain.CreateEasy;
import site.cleanfree.be_admin.testservice.domain.CreateEasyAccess;
import site.cleanfree.be_admin.testservice.domain.CreateValue;
import site.cleanfree.be_admin.testservice.domain.CreateValueAccess;
import site.cleanfree.be_admin.testservice.domain.CureSilver;
import site.cleanfree.be_admin.testservice.domain.CureSilverAccess;
import site.cleanfree.be_admin.testservice.domain.Visa;
import site.cleanfree.be_admin.testservice.domain.VisaAccess;
import site.cleanfree.be_admin.testservice.dto.GoogleSheetCountResponseDto;
import site.cleanfree.be_admin.testservice.dto.RegisterDto;
import site.cleanfree.be_admin.testservice.dto.ServiceRegisterDto;
import site.cleanfree.be_admin.testservice.infrastructure.CarryCabinAccessRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CarryCabinRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CookingStationAccessRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CookingStationRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CozyHouseAccessRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CozyHouseRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CozyquickAccessRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CozyquickRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CreateEasyAccessRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CreateEasyRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CreateValueAccessRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CreateValueRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CureSilverAccessRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CureSilverRepository;
import site.cleanfree.be_admin.testservice.infrastructure.VisaAccessRepository;
import site.cleanfree.be_admin.testservice.infrastructure.VisaRepository;

@Service
@RequiredArgsConstructor
public class GoogleSheetService {

    private final CarryCabinRepository carryCabinRepository;
    private final CarryCabinAccessRepository carryCabinAccessRepository;
    private final CookingStationRepository cookingStationRepository;
    private final CookingStationAccessRepository cookingStationAccessRepository;
    private final CozyquickRepository cozyquickRepository;
    private final CozyquickAccessRepository cozyquickAccessRepository;
    private final CozyHouseRepository cozyHouseRepository;
    private final CozyHouseAccessRepository cozyHouseAccessRepository;
    private final VisaRepository visaRepository;
    private final VisaAccessRepository visaAccessRepository;
    private final CreateValueRepository createValueRepository;
    private final CreateValueAccessRepository createValueAccessRepository;
    private final CreateEasyRepository createEasyRepository;
    private final CreateEasyAccessRepository createEasyAccessRepository;
    private final CureSilverRepository cureSilverRepository;
    private final CureSilverAccessRepository cureSilverAccessRepository;

    public List<GoogleSheetCountResponseDto> getServiceCount() {
        List<CarryCabin> carryCabins = carryCabinRepository.findAll();
        List<CarryCabinAccess> carryCabinAccesses = carryCabinAccessRepository.findAll();

        List<CookingStation> cookingStations = cookingStationRepository.findAll();
        List<CookingStationAccess> cookingStationAccesses = cookingStationAccessRepository.findAll();

        List<Cozyquick> cozyquicks = cozyquickRepository.findAll();
        List<CozyquickAccess> cozyquickAccesses = cozyquickAccessRepository.findAll();

        List<CozyHouse> cozyHouses = cozyHouseRepository.findAll();
        List<CozyHouseAccess> cozyHouseAccesses = cozyHouseAccessRepository.findAll();

        List<Visa> visas = visaRepository.findAll();
        List<VisaAccess> visaAccesses = visaAccessRepository.findAll();

        List<CreateValue> createValues = createValueRepository.findAll();
        List<CreateValueAccess> createValueAccesses = createValueAccessRepository.findAll();

        List<CreateEasy> createEasies = createEasyRepository.findAll();
        List<CreateEasyAccess> createEasyAccesses = createEasyAccessRepository.findAll();

        List<CureSilver> cureSilvers = cureSilverRepository.findAll();
        List<CureSilverAccess> cureSilverAccesses = cureSilverAccessRepository.findAll();

        return List.of(
            GoogleSheetCountResponseDto.builder()
                .service("carry cabin")
                .registerCount(carryCabins.size())
                .accessCount(carryCabinAccesses.stream()
                    .mapToInt(CarryCabinAccess::getCount)
                    .sum())
                .build(),
            GoogleSheetCountResponseDto.builder()
                .service("cooking station")
                .registerCount(cookingStations.size())
                .accessCount(cookingStationAccesses.stream()
                    .mapToInt(CookingStationAccess::getCount)
                    .sum())
                .build(),
            GoogleSheetCountResponseDto.builder()
                .service("cozy quick")
                .registerCount(cozyquicks.size())
                .accessCount(cozyquickAccesses.stream()
                    .mapToInt(CozyquickAccess::getCount)
                    .sum())
                .build(),
            GoogleSheetCountResponseDto.builder()
                .service("cozy house")
                .registerCount(cozyHouses.size())
                .accessCount(cozyHouseAccesses.stream()
                    .mapToInt(CozyHouseAccess::getCount)
                    .sum())
                .build(),
            GoogleSheetCountResponseDto.builder()
                .service("clear visa")
                .registerCount(visas.size())
                .accessCount(visaAccesses.stream()
                    .mapToInt(VisaAccess::getCount)
                    .sum())
                .build(),
            GoogleSheetCountResponseDto.builder()
                .service("create value")
                .registerCount(createValues.size())
                .accessCount(createValueAccesses.stream()
                    .mapToInt(CreateValueAccess::getCount)
                    .sum())
                .build(),
            GoogleSheetCountResponseDto.builder()
                .service("create easy")
                .registerCount(createEasies.size())
                .accessCount(createEasyAccesses.stream()
                    .mapToInt(CreateEasyAccess::getCount)
                    .sum())
                .build(),
            GoogleSheetCountResponseDto.builder()
                .service("cure silver")
                .registerCount(cureSilvers.size())
                .accessCount(cureSilverAccesses.stream()
                    .mapToInt(CureSilverAccess::getCount)
                    .sum())
                .build()
        );
    }

    public List<ServiceRegisterDto> getRegister() {
        List<CozyHouse> cozyHouses = cozyHouseRepository.findAll();
        List<Visa> visas = visaRepository.findAll();
        List<CarryCabin> carryCabins = carryCabinRepository.findAll();

        return List.of(
            ServiceRegisterDto.builder()
                .service("cosy house")
                .registrations(cozyHouses.stream()
                    .filter(cozyHouse -> cozyHouse.getName() != null
                        && cozyHouse.getPhoneNumber() != null)
                    .map(cozyHouse -> RegisterDto.builder()
                        .name(cozyHouse.getName())
                        .phoneNumber(cozyHouse.getPhoneNumber())
                        .build()
                    ).toList())
                .build(),
            ServiceRegisterDto.builder()
                .service("clear visa")
                .registrations(visas.stream()
                    .filter(visa -> visa.getName() != null
                        && visa.getPhoneNumber() != null)
                    .map(visa -> RegisterDto.builder()
                        .name(visa.getName())
                        .phoneNumber(visa.getPhoneNumber())
                        .build()
                    ).toList())
                .build(),
            ServiceRegisterDto.builder()
                .service("carry cabin")
                .registrations(carryCabins.stream()
                    .filter(cabin -> cabin.getName() != null
                        && cabin.getEmail() != null)
                    .map(cabin -> RegisterDto.builder()
                        .name(cabin.getName())
                        .phoneNumber(cabin.getEmail())
                        .build()
                    ).toList())
                .build()
        );
    }
}
