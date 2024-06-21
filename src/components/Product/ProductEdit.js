import React, { useState } from 'react';
import { Dialog, DialogContent, DialogTitle, TextField, Button, Grid } from '@material-ui/core';

function ProductEdit({ open, onClose, product, onSave }) {
  const [formData, setFormData] = useState({
    name: product.name,
    description: product.description,
    price: product.price
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleSave = () => {
    onSave(formData);
    onClose();
  };

  return (
    <Dialog open={open} onClose={onClose} aria-labelledby="edit-product-title">
      <DialogTitle id="edit-product-title">Edit Product</DialogTitle>
      <DialogContent>
        <Grid container spacing={2}>
          <Grid item xs={12}>
            <TextField
              autoFocus
              margin="dense"
              id="name"
              name="name"
              label="Product Name"
              type="text"
              fullWidth
              value={formData.name}
              onChange={handleChange}
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              margin="dense"
              id="description"
              name="description"
              label="Product Description"
              type="text"
              fullWidth
              multiline
              rows={4}
              value={formData.description}
              onChange={handleChange}
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              margin="dense"
              id="price"
              name="price"
              label="Price"
              type="number"
              fullWidth
              value={formData.price}
              onChange={handleChange}
            />
          </Grid>
          <Grid item xs={12}>
            <Button onClick={handleSave} color="primary" variant="contained">Save Changes</Button>
            <Button onClick={onClose} color="secondary" variant="contained" style={{ marginLeft: '10px' }}>Cancel</Button>
          </Grid>
        </Grid>
      </DialogContent>
    </Dialog>
  );
}

export default ProductEdit;
