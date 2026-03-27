package za.ac.cput.repositoryImpl;
/**
 * @author Aiden Wallace 222471174
 */

import za.ac.cput.Domain.Auction;
import za.ac.cput.Repository.IAuctionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AuctionRepository implements IAuctionRepository {

   // private Map<Long, Auction> data = new HashMap<>();

    private static AuctionRepository repository = null;

    private List<Auction> data;

    private AuctionRepository(){
            data = new ArrayList<>();
    }

    public static AuctionRepository getRepository(){
        if (repository == null){
            repository = new AuctionRepository();
        }
        return repository;
    }

    @Override
    public Auction create(Auction auction) {
        data.add(auction );
        return auction;
    }

    @Override
    public Auction read(Long auctionID) {
        for (Auction auction : data){
            if (auction.getAuctionID().equals(auctionID))
                return auction;
        }
        return null;
    }

    @Override
    public Auction update(Auction auction) {
            Auction existingAuction = read(auction.getAuctionID());
            if (existingAuction != null){
                data.remove(existingAuction);
                data.add(auction);

                return auction;
            }
        return null;
    }

    @Override
    public Boolean delete(Long auctionID) {
        Auction auction = read(auctionID);
        if (auction != null){
            data.remove(auction);
            return true;
        }
        return null;
    }

    @Override
    public List<Auction> getAll() {
        return data;
    }

}
