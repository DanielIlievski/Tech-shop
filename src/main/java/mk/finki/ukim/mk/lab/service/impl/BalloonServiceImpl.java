package mk.finki.ukim.mk.lab.service.impl;


import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.model.enumerations.BalloonStatus;
import mk.finki.ukim.mk.lab.model.exception.BalloonNotFoundException;
import mk.finki.ukim.mk.lab.repository.BalloonRepository;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//6to baranje
@Service
public class BalloonServiceImpl implements BalloonService {

    private final BalloonRepository balloonRepository;
    private final ManufacturerService manufacturerService;

    public BalloonServiceImpl(BalloonRepository balloonRepository, ManufacturerService manufacturerService) {
        this.balloonRepository = balloonRepository;
        this.manufacturerService = manufacturerService;
    }

    @Override
    public List<Balloon> listAll() {
        return this.balloonRepository.findAll();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        if (text != null) {
            text = String.format("%%%s%%", text);
        }
        return this.balloonRepository.findAllByNameLikeOrDescriptionLike(text);
    }

    @Override
    public List<Balloon> findByStatus(BalloonStatus status) {
        return balloonRepository.findAllByStatus(status);
    }

    @Override
    public List<String> findAllStatuses() {
        return Arrays.stream(BalloonStatus.values()).map(Enum::name).collect(Collectors.toList());
    }

    @Override
    public Balloon findById(Long id) {
        return this.balloonRepository.findById(id)
                .orElseThrow(() -> new BalloonNotFoundException(id));
    }

    @Override
    public Balloon save(Balloon balloon) {
        Manufacturer m = balloon.getManufacturer();
        if (m != null) {
            balloon.setManufacturer(this.manufacturerService.findById(m.getId()));
        }
        return this.balloonRepository.save(balloon);
    }

    @Override
    public void deleteById(Long id) {
        this.balloonRepository.deleteById(id);
    }


}
