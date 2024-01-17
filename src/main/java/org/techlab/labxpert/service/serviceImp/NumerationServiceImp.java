package org.techlab.labxpert.service.serviceImp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techlab.labxpert.dtos.AnalyseDTO;
import org.techlab.labxpert.dtos.NumerationDTO;
import org.techlab.labxpert.entity.Numeration;
import org.techlab.labxpert.repository.NumerationRepository;
import org.techlab.labxpert.service.I_Numeration;

import java.util.List;
@Service
public class NumerationServiceImp implements I_Numeration {

    @Autowired
    NumerationRepository numerationRepository;

    ModelMapper modelMapper=new ModelMapper();
    @Override
    public NumerationDTO addNumeration(NumerationDTO numerationDTO) {
        Numeration numeration=numerationRepository.save(modelMapper.map(numerationDTO,Numeration.class));
        return modelMapper.map(numeration,NumerationDTO.class);
    }

    @Override
    public NumerationDTO modNumeration(NumerationDTO numerationDTO) {
        Numeration numeration=numerationRepository.save(modelMapper.map(numerationDTO,Numeration.class));
        return modelMapper.map(numeration,NumerationDTO.class);
    }

    @Override
    public Boolean delNumeration(NumerationDTO numerationDTO) {
        Numeration numeration=numerationRepository.save(modelMapper.map(numerationDTO,Numeration.class));
        return numeration.getDeleted();
    }

    @Override
    public List<NumerationDTO> allNumerationWithAnalyse(AnalyseDTO analyseDTO) {
        return null;
    }

    @Override
    public List<NumerationDTO> allNumeration() {
        return null;
    }
}
