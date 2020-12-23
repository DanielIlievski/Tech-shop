package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.enumerations.BalloonStatus;

import java.util.List;
// 5 baranje
public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
    List<Balloon> findByStatus(BalloonStatus status);
    List<String> findAllStatuses();
    Balloon findById(Long id);
    Balloon save(Balloon balloon);
    void deleteById(Long id);
}