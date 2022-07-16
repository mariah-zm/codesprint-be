package com.inquizit.converter;

import com.inquizit.model.domain.Quiz;
import com.inquizit.model.domain.QuizInfo;
import com.inquizit.model.domain.User;
import com.inquizit.model.input.QuizInfoInput;
import com.inquizit.model.output.QuizInfoResponse;
import com.inquizit.model.output.QuizResponse;
import com.inquizit.model.output.UserOutput;

import java.util.ArrayList;
import java.util.List;

public class DomainToOutput {

    private DomainToOutput () {
    }

    /**
     * Converts a user object in domain format to output format by changing the role type from
     * {@link com.inquizit.model.enums.RoleType} to int and renaming property
     *
     * @param user object in domain format
     * @return a {@link UserOutput} object
     */
    public static UserOutput convert(User user) {
        return new UserOutput(user.getEmail(), user.getName(), user.getType().getValue());
    }

    public static QuizResponse convert(Quiz quiz) {
        return new QuizResponse(
                quiz.getName(),
                quiz.getQuestions(),
                quiz.getPassingScore(),
                quiz.getMsgSuccess(),
                quiz.getMsgFailure(),
                quiz.isShowCorrect()
        );
    }

    public static List<QuizInfoResponse> convert(List<QuizInfo> domainList) {
        List<QuizInfoResponse> responseList = new ArrayList<>();

        for (QuizInfo info: domainList) {
            responseList.add(new QuizInfoResponse(
                    info.getName(),
                    info.getId(),
                    info.getDescription(),
                    info.getAmountQuestions()
            ));
        }

        return responseList;
    }

}
