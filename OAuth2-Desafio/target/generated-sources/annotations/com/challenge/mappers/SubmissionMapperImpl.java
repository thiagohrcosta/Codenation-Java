package com.challenge.mappers;

import com.challenge.dto.SubmissionDTO;
import com.challenge.entity.Challenge;
import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import com.challenge.entity.User;
import java.math.BigDecimal;
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
public class SubmissionMapperImpl implements SubmissionMapper {

    @Override
    public SubmissionDTO map(Submission submission) {
        if ( submission == null ) {
            return null;
        }

        SubmissionDTO submissionDTO = new SubmissionDTO();

        if ( submission.getCreatedAt() != null ) {
            submissionDTO.setCreatedAt( DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm" ).format( submission.getCreatedAt() ) );
        }
        if ( submission.getScore() != null ) {
            submissionDTO.setScore( BigDecimal.valueOf( submission.getScore() ) );
        }
        submissionDTO.setChallengeId( submissionIdChallengeId( submission ) );
        Long id1 = submissionIdUserId( submission );
        if ( id1 != null ) {
            submissionDTO.setUserId( String.valueOf( id1 ) );
        }

        return submissionDTO;
    }

    @Override
    public List<SubmissionDTO> map(List<Submission> submissions) {
        if ( submissions == null ) {
            return null;
        }

        List<SubmissionDTO> list = new ArrayList<SubmissionDTO>( submissions.size() );
        for ( Submission submission : submissions ) {
            list.add( map( submission ) );
        }

        return list;
    }

    private Long submissionIdChallengeId(Submission submission) {
        if ( submission == null ) {
            return null;
        }
        SubmissionId id = submission.getId();
        if ( id == null ) {
            return null;
        }
        Challenge challenge = id.getChallenge();
        if ( challenge == null ) {
            return null;
        }
        Long id1 = challenge.getId();
        if ( id1 == null ) {
            return null;
        }
        return id1;
    }

    private Long submissionIdUserId(Submission submission) {
        if ( submission == null ) {
            return null;
        }
        SubmissionId id = submission.getId();
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
