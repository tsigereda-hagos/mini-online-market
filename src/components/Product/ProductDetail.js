import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import CssBaseline from '@material-ui/core/CssBaseline';
import Box from '@material-ui/core/Box';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Button from '@material-ui/core/Button';
import EditProductModal from './EditProductModal';
import ShoppingCart from '../../containers/ShoppingCart/ShoppingCart';
import Reviews from '../../containers/Reviews/Reviews';
import api from '../../configuration/api';
import { authenticationService } from '../../services/authentication.service';
import ProductEdit from './ProductEdit';

const drawerWidth = 240;

const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex',
  },
  appBarSpacer: theme.mixins.toolbar,
  content: {
    flexGrow: 1,
    height: '100vh',
    overflow: 'auto',
  },
  container: {
    paddingTop: theme.spacing(4),
    paddingBottom: theme.spacing(4),
  },
  paper: {
    padding: theme.spacing(2),
    display: 'flex',
    flexDirection: 'column',
  },
}));

export default function ProductDetail(props) {
  const classes = useStyles();
  const [product, setProduct] = useState(null);
  const [editModalOpen, setEditModalOpen] = useState(false);

  useEffect(() => {
    const fetchProductDetail = () => {
      api.get(`products/${props.productId}`)
        .then(response => setProduct(response.data))
        .catch(error => console.error("Failed to fetch product details", error));
    };

    fetchProductDetail();
  }, [props.productId]);

  const handleEditProduct = () => {
    setEditModalOpen(true);
  };

  const handleCloseModal = () => {
    setEditModalOpen(false);
  };

  const handleSaveProduct = (updatedProduct) => {
    console.log("Product Updated", updatedProduct);
    // Here you would typically send a request to your API to save the updated product
    setProduct(updatedProduct); // Update the product details in the local state
    handleCloseModal();
    // Optionally refetch the product details if required
  };

  const addToCart = () => {
    const userId = authenticationService.currentUserValue.userId;
    api.get(`buyers/${userId}/shoppingcart`)
      .then(response => {
        let products = response.data;
        products.push(product);
        api.patch(`buyers/${userId}/shoppingcart`, products)
          .then(() => console.log("Product added to cart"))
          .catch(error => console.error("Failed to add product to cart", error));
      });
  };

  return (
    <div className={classes.root}>
      <CssBaseline />
      <main className={classes.content}>
        <div className={classes.appBarSpacer} />
        <Container maxWidth="lg" className={classes.container}>
          <Grid container spacing={3}>
            <Grid item xs={12} md={8} lg={9}>
              <Paper className={classes.paper}>
                {product && (
                  <>
                    <h3>{product.name}</h3>
                    <h5>{product.description}</h5>
                    <Button onClick={addToCart}>Add to Cart</Button>
                    <Button color="primary" onClick={handleEditProduct}>
                      Edit Product
                    </Button>
                  </>
                )}
              </Paper>
            </Grid>
            <Grid item xs={12} md={4} lg={3}>
              <h1>My Shopping Cart</h1>
              <ShoppingCart />
            </Grid>
            <Grid item xs={12}>
              <Reviews productId={props.productId} />
            </Grid>
          </Grid>
        </Container>
        {editModalOpen && product && (
          <ProductEdit
            product={product}
            open={editModalOpen}
            onClose={handleCloseModal}
            onSave={handleSaveProduct}
          />
        )}
      </main>
    </div>
  );
}
