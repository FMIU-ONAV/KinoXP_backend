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

    public List<SnackDTO> saveSnack(List<SnackDTO> snackDTO) {
        /*Snack snackToSave = snackConverter.toEntity(snackDTO);
        // ensure its a create
        snackToSave.setSnack_ID(0);
        Snack savedSnack = snackRepository.save(snackToSave);

        return snackConverter.toDTO(savedSnack);*/
        List<Snack> saveSnacks = new ArrayList<>();

        for (SnackDTO Snacks : snackDTO) {
            Snack snackToSave = snackConverter.toEntity(Snacks);
            saveSnacks.add(snackToSave);
            snackRepository.save(snackToSave);
        }

        System.out.println(saveSnacks);
        return saveSnacks.stream().map(snackConverter::toDTO).collect(Collectors.toList());
    }


}
