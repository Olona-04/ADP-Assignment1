package za.ac.cput.repositoryImpl;

/**
 *
 * @author keano
 */

import za.ac.cput.Domain.Bid;
import za.ac.cput.Repository.IBidRepository;

import java.util.*;

public class BidRepository implements IBidRepository {

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