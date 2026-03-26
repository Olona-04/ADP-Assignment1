package Repository.Impl;

/**
 *
 * @author keano
 */

import Domain.Bid;
import Repository.BidRepository;

import java.util.*;

public class BidRepositoryImpl implements BidRepository {

    private Map<String, Bid> bidDB = new HashMap<>();

    @Override
    public Bid create(Bid bid) {
        bidDB.put(bid.getBidId(), bid);
        return bid;
    }

    @Override
    public Bid read(String id) {
        return bidDB.get(id);
    }

    @Override
    public Bid update(Bid bid) {
        bidDB.put(bid.getBidId(), bid);
        return bid;
    }

    @Override
    public boolean delete(String id) {
        return bidDB.remove(id) != null;
    }

    @Override
    public List<Bid> getAll() {
        return new ArrayList<>(bidDB.values());
    }
}