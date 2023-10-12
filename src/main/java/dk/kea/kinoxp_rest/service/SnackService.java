package dk.kea.kinoxp_rest.service;

import dk.kea.kinoxp_rest.dto.SnackConverter;
import dk.kea.kinoxp_rest.dto.SnackDTO;
import dk.kea.kinoxp_rest.model.Snack;
import dk.kea.kinoxp_rest.repository.SnackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SnackService {

    @Autowired
    private final SnackRepository snackRepository;
    @Autowired
    private final SnackConverter snackConverter;

    public SnackService(SnackRepository snackRepository, SnackConverter snackConverter) {
        this.snackRepository = snackRepository;
        this.snackConverter = snackConverter;
    }

    public SnackDTO saveSnack(SnackDTO snackDTO) {
        Snack snackToSave = snackConverter.toEntity(snackDTO);
        // ensure its a create
        snackToSave.setSnack_ID(0);
        Snack savedSnack = snackRepository.save(snackToSave);
        return snackConverter.toDTO(savedSnack);

    }

    public SnackDTO updateSnack(int id, SnackDTO snackDTO) {
        Snack snackToUpdate = snackConverter.toEntity(snackDTO);
        snackToUpdate.setSnack_ID(id);
        Snack updatedSnack = snackRepository.save(snackToUpdate);
        return snackConverter.toDTO(updatedSnack);
    }


}
