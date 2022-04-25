package hcmute.spkt.nguyenphucan19110321.uidesign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

import hcmute.spkt.nguyenphucan19110321.uidesign.R;
import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.holder.InvoiceHolder;
import hcmute.spkt.nguyenphucan19110321.uidesign.adapter.holder.NotifyHolder;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Notify;
import hcmute.spkt.nguyenphucan19110321.uidesign.model.Order;

public class InvoiceAdapter extends RecyclerView.Adapter<InvoiceHolder> {
    private Context context;
    private List<Order> invoiceList;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" HH:mm MM-dd-yyyy");
    public InvoiceAdapter(Context context,List<Order> invoiceList){
        this.invoiceList = invoiceList;
        this.context = context;
    }

    @NonNull
    @Override
    public InvoiceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InvoiceHolder(LayoutInflater.from(context).inflate(R.layout.item_invoice,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull InvoiceHolder holder, int position) {
        Order invoice = invoiceList.get(position);
        holder.tvTitle.setText(invoice.getNameShop());
        holder.tvPrice.setText(String.valueOf(invoice.getPrice()));
        holder.tvTime.setText(simpleDateFormat.format(invoice.getTime()));
    }

    @Override
    public int getItemCount() {
        return invoiceList.size();
    }
}
