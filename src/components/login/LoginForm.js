import { TextField, Button } from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
  form: {
    '& > *': {
      margin: theme.spacing(1),
      width: '25ch',
    },
  },
  button: {
    margin: theme.spacing(1),
  }
}));

export default function LoginForm() {
  const classes = useStyles();

  return (
    <form className={classes.form} noValidate autoComplete="off">
      <TextField id="username" label="Username" variant="outlined" />
      <TextField id="password" label="Password" variant="outlined" type="password" />
      <Button variant="contained" color="primary" className={classes.button}>
        Login
      </Button>
    </form>
  );
}
