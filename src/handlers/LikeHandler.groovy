package handlers

import model.Candidate
import model.Company
import model.Job
import model.Like

class LikeHandler {

    Map<Integer, Like> filterByCandidate(Candidate candidate, Map<Integer, Like> likes) {
        Map<Integer, Like> filtered = [:]

        for (like in likes) {
            if (like.getValue().getCandidate() == null) {
                continue
            }

            if (like.getValue().getCandidate().getId() == candidate.getId()) {
                filtered.put(like.getKey(), like.getValue())
            }
        }

        return filtered
    }

    Map<Integer, Like> filterByCompany(Company company, Map<Integer, Like> likes) {
        Map<Integer, Like> filtered = [:]

        for (like in likes) {
            if (like.getValue().getCompany() == null) {
                continue
            }

            if (like.getValue().getCompany().getId() == company.getId()) {
                filtered.put(like.getKey(), like.getValue())
            }
        }

        return filtered
    }

    Map<Integer, Like> filterByJob(Job job, Map<Integer, Like> likes) {
        Map<Integer, Like> filtered = [:]

        for (like in likes) {
            if (like.getValue().getJob() == null) {
                continue
            }

            if (like.getValue().getJob().getId() == job.getId()) {
                filtered.put(like.getKey(), like.getValue())
            }
        }

        return filtered
    }

    Integer generateLikeId(Map<Integer, Like> likes) {
        return likes.size() > 0 ? likes.size() + 1 : 1
    }

    Integer getCompanyLikeIdsIfExists(Candidate candidate, Job job, Map<Integer, Like> likes) {
        Map<Integer, Like> likesByCompany = filterByCompany(job.getCompany(), likes)
        Map<Integer, Like> likesByCandidate = filterByCandidate(candidate, likesByCompany)

        return likesByCandidate.size() > 0 ? likesByCandidate.values()[0].getId() : 0
    }

    def getCandidateLikeIdsIfExists(Candidate candidate, Company company, Map<Integer, Like> likes) {
        Map<Integer, Like> likesByCandidate = filterByCandidate(candidate, likes)

        Map<Integer, Like> likesByCompany = [:]
        for (like in likesByCandidate) {
            if (like.getValue().getJob() == null) {
                if (like.getValue().getCompany() == null) {
                    continue
                }
                if (like.getValue().getCompany().getId() == company.getId()) {
                    likesByCompany.put(like.getKey(), like.getValue())
                }
            } else if (like.getValue().getJob().getCompany().getId() == company.getId()) {
                likesByCompany.put(like.getKey(), like.getValue())
            }
        }

        return likesByCompany.size() > 0 ? likesByCandidate : [0]
    }

    boolean hasCandidateAlreadyLikedJob(Candidate candidate, Job job, Map<Integer, Like> likes) {
        Map<Integer, Like> likesByCandidate = filterByCandidate(candidate, likes)
        Map<Integer, Like> likesByJob = filterByJob(job, likesByCandidate)

        return likesByJob.size() > 0
    }


    void createUserLike(Candidate candidate, Job job, Map<Integer, Like> likes) {
        if (hasCandidateAlreadyLikedJob(candidate, job, likes)) {
            return
        }

        Integer likeId = getCompanyLikeIdsIfExists(candidate, job, likes)
        Like like = likeId == 0 ? new Like(generateLikeId(likes)) : likes.get(likeId)

        like.setCandidate(candidate)
        like.setJob(job)

        likes.put(like.getId(), like)
    }

    void createCompanyLike(Company company, Candidate candidate, Map<Integer, Like> likes) {
        def likeIds = getCandidateLikeIdsIfExists(candidate, company, likes)

        for (likeId in likeIds) {
            Like like

            if (likeId == 0) {
                like = new Like(generateLikeId(likes))
            } else {
                like = likes.get(likeId.getValue().getId())
            }

            like.setCompany(company)
            like.setCandidate(candidate)

            likes.put(like.getId(), like)
        }
    }
}
