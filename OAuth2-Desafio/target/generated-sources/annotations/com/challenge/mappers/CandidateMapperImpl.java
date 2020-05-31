package com.challenge.mappers;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Acceleration;
import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.entity.Company;
import com.challenge.entity.User;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-30T20:44:42-0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_212 (Amazon.com Inc.)"
)
@Component
public class CandidateMapperImpl implements CandidateMapper {

    @Override
    public CandidateDTO map(Candidate candidate) {
        if ( candidate == null ) {
            return null;
        }

        CandidateDTO candidateDTO = new CandidateDTO();

        if ( candidate.getCreatedAt() != null ) {
            candidateDTO.setCreatedAt( DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm" ).format( candidate.getCreatedAt() ) );
        }
        candidateDTO.setCompanyId( candidateIdCompanyId( candidate ) );
        candidateDTO.setAccelerationId( candidateIdAccelerationId( candidate ) );
        candidateDTO.setUserId( candidateIdUserId( candidate ) );
        candidateDTO.setStatus( candidate.getStatus() );

        return candidateDTO;
    }

    @Override
    public List<CandidateDTO> map(List<Candidate> candidates) {
        if ( candidates == null ) {
            return null;
        }

        List<CandidateDTO> list = new ArrayList<CandidateDTO>( candidates.size() );
        for ( Candidate candidate : candidates ) {
            list.add( map( candidate ) );
        }

        return list;
    }

    private Long candidateIdCompanyId(Candidate candidate) {
        if ( candidate == null ) {
            return null;
        }
        CandidateId id = candidate.getId();
        if ( id == null ) {
            return null;
        }
        Company company = id.getCompany();
        if ( company == null ) {
            return null;
        }
        Long id1 = company.getId();
        if ( id1 == null ) {
            return null;
        }
        return id1;
    }

    private Long candidateIdAccelerationId(Candidate candidate) {
        if ( candidate == null ) {
            return null;
        }
        CandidateId id = candidate.getId();
        if ( id == null ) {
            return null;
        }
        Acceleration acceleration = id.getAcceleration();
        if ( acceleration == null ) {
            return null;
        }
        Long id1 = acceleration.getId();
        if ( id1 == null ) {
            return null;
        }
        return id1;
    }

    private Long candidateIdUserId(Candidate candidate) {
        if ( candidate == null ) {
            return null;
        }
        CandidateId id = candidate.getId();
        if ( id == null ) {
            return null;
        }
        User user = id.getUser();
        if ( user == null ) {
            return null;
        }
        Long id1 = user.getId();
        if ( id1 == null ) {
            return null;
        }
        return id1;
    }
}
